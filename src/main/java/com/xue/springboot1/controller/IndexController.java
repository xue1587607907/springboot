package com.xue.springboot1.controller;

import com.xue.springboot1.utils.SqlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class IndexController {

    @RequestMapping(value = "addTableField")
    public String addTableField(Model model, String tableSchema, String tableName, String columnName, String sql) {
        model.addAttribute("sql", SqlUtils.addTableField(tableSchema, tableName, columnName, sql));
        return "procedure";
    }

    @RequestMapping(value = "modifyTableField")
    public String modifyTableField(Model model, String tableSchema, String tableName, String columnName, String sql) {
        model.addAttribute("sql", SqlUtils.modifyTableField(tableSchema, tableName, columnName, sql));
        return "procedure";
    }

    @RequestMapping(value = "dropColumn")
    public String dropColumn(Model model, String tableSchema, String tableName, String columnName, String sql) {
        model.addAttribute("sql", SqlUtils.dropColumn(tableSchema, tableName, columnName, sql));
        return "procedure";
    }

    @RequestMapping(value = "modifyTableFieldName")
    public String modifyTableFieldName(Model model, String tableSchema, String tableName, String columnName, String sql, String newName) {
        model.addAttribute("sql", SqlUtils.modifyTableFieldName(tableSchema, tableName, columnName, sql, newName));
        return "procedure";
    }

    @RequestMapping(value = "addIndex")
    public String addIndex(Model model, String tableSchema, String tableName, String indexName, String sql) {
        model.addAttribute("sql", SqlUtils.addIndex(tableSchema, tableName, indexName, sql));
        return "procedure";
    }

    @RequestMapping(value = "dropIndex")
    public String dropIndex(Model model, String tableSchema, String tableName, String indexName, String sql) {
        model.addAttribute("sql", SqlUtils.dropIndex(tableSchema, tableName, indexName, sql));
        return "procedure";
    }

    @RequestMapping(value = "modifyIndexName")
    public String modifyIndexName(Model model, String tableSchema, String tableName, String indexName, String sql, String newIndexName) {
        model.addAttribute("sql", SqlUtils.modifyIndexName(tableSchema, tableName, indexName, sql, newIndexName));
        return "procedure";
    }
}
