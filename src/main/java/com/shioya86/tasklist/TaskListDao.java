package com.shioya86.tasklist;

import com.shioya86.tasklist.HomeController.TaskItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskListDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    TaskListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(TaskItem taskItem) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(taskItem);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("tasklist");
        insert.execute(param);
    }

    public int delete(String id) {
        int number = jdbcTemplate.update("delete from tasklist where id = ?", id);
        return number;
    }

    public int update(TaskItem taskItem) {
        int number = jdbcTemplate.update(
                "update tasklist set task = ?, deadline = ?, done = ? where id = ?",
                taskItem.task(),
                taskItem.deadline(),
                taskItem.done(),
                taskItem.id());
        return number;
    }

    public List<TaskItem> findAll() {
        String query = "select * from tasklist";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        List<TaskItem> taskItems = result.stream()
                .map((Map<String, Object> row) -> new TaskItem(
                        row.get("id").toString(),
                        row.get("task").toString(),
                        row.get("deadline").toString(),
                        (Boolean) row.get("done")))
                .toList();

        return taskItems;
    }
}
