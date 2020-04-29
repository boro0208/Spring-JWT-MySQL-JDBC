package com.test.test.dao;

import com.test.test.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class JdbcInvoiceDao implements com.test.test.dao.InvoiceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void addInvoice(Invoice invoice) {
        jdbcTemplate.update("insert into invoice (Description, Amount, Status , DateOfInvoice) " + "values(?, ?, ?, ?)",
                invoice.getDescription(), invoice.getAmount(), invoice.getStatus(), invoice.getDateOfInvoice());
    }

    @Override
    public List<Invoice> findAll() {
        return jdbcTemplate.query(
                "SELECT \n" +
                        "    i.InvoiceNumber,\n" +
                        "    i.Description,\n" +
                        "    i.Amount,\n" +
                        "    s.Status,\n" +
                        "    i.DateOfInvoice\n" +
                        "FROM\n" +
                        "    invoice i\n" +
                        "        INNER JOIN\n" +
                        "    invoice_status s ON i.Status = s.id;",
                (rs, rowNum) ->
                        new Invoice(
                                rs.getInt("InvoiceNumber"),
                                rs.getString("Description"),
                                rs.getInt("Amount"),
                                rs.getString("Status"),
                                rs.getString("DateOfInvoice")
                        )
        );
    }

    @Override
    public Invoice findById(int InvoiceNumber) {
        String sql = "SELECT i.InvoiceNumber, i.Description, i.Amount, s.status, i.DateOfInvoice FROM invoice i INNER JOIN invoice_status s ON i.Status = s.id where i.InvoiceNumber = ?";
        RowMapper<Invoice> rowMapper = new BeanPropertyRowMapper<Invoice>(Invoice.class);
        Invoice article = jdbcTemplate.queryForObject(sql, rowMapper, InvoiceNumber);
        return article;
    }

    @Override
    public void deleteById(int InvoiceNumber) {
        jdbcTemplate.update(
                "delete from invoice where InvoiceNumber =?",
                InvoiceNumber);
    }

    @Override
    public void editInvoice(Invoice invoice) {
        jdbcTemplate.update("UPDATE invoice \n" +
                        "SET \n" +
                        "    Description = ?,\n" +
                        "    Amount = ?,\n" +
                        "    Status = ?,\n" +
                        "    DateOfInvoice = ?\n" +
                        "WHERE\n" +
                        "    InvoiceNumber = ?;",
                invoice.getDescription(), invoice.getAmount(), invoice.getStatus(), invoice.getDateOfInvoice(), invoice.getInvoiceNumber());
    }

}
