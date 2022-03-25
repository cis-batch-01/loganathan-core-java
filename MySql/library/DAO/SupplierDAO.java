package com.technocis.library.DAO;

import java.util.List;

import com.technocis.library.model.Supplier;

public interface SupplierDAO {
	public Supplier getSupplier(int id);
	public List<Supplier> getAllSupplier();
	public Supplier addSupplier(Supplier supplier);
	public Supplier updateSupplier(int id,Supplier supplier);
	public Supplier deleteSupplier(int id);

}
