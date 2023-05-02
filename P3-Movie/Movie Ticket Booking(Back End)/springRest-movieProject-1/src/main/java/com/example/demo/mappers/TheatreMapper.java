package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Theatre;


public final class TheatreMapper implements RowMapper<Theatre> {

    public Theatre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Theatre theatre=new Theatre();
        theatre.setTheatreId(rs.getLong("theatreId"));
        theatre.setTheatreName(rs.getString("theatreName"));
        return theatre;
    } 
}