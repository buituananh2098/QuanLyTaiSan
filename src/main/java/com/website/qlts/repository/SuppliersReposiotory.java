package com.website.qlts.repository;

import com.website.qlts.models.CategoriesSupplier;
import com.website.qlts.models.Suppliers;
import com.website.qlts.models.SuppliersModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliersReposiotory extends JpaRepository<Suppliers, Long> {
    @Query(value = "SELECT * FROM suppliers c WHERE c.name LIKE %:name%", nativeQuery = true)
    public List<Suppliers> getByName(@Param("name") String name);

    @Query(value = "SELECT * FROM suppliers ", nativeQuery = true)
    public List<CategoriesSupplier> getCate();

    @Query(value = "SELECT c.id,c.address,c.phone_number,s.name FROM suppliers s INNER JOIN categories_supplier c ON s.supplier_category_id = c.id", nativeQuery = true)
    public List<SuppliersModels> getListSup();
}
