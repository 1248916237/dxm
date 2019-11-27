package com.sc.crm.service;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Product;
import com.sc.crm.bean.ProductMaterial;

public interface ProductService {
	
	
	public PageInfo<Product> getProductList(int pn,int size);
	
	public void delProduct(Product product);
	
	public void addProduct(Product product);
	
	public Product selProductById(Product product);
	
	public void uptProduct(Product product);
	
	public PageInfo<Product> selProductList(int pn,int size,Product product);
	
	public PageInfo<ProductMaterial> selProductMaterial(int pn,int size,String productId);
	
	public void delProductMaterial(ProductMaterial product);
	
	public void addProductMaterial(ProductMaterial product);
	
	public ProductMaterial updateProductMaterial(ProductMaterial productMaterial);
	
	public void uptProductMaterial(ProductMaterial product);
	
}
