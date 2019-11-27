package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Product;
import com.sc.crm.bean.ProductMaterial;
import com.sc.crm.dao.MaterialMapper;
import com.sc.crm.dao.ProductMapper;
import com.sc.crm.dao.ProductMaterialMapper;
import com.sc.crm.service.ProductService;

@Service("/productservice")
public class ProductServiceImpl implements ProductService{
	
	@Resource
	private SqlSessionTemplate st;

	@Override
	public PageInfo<Product> getProductList(int pn, int size) {
		ProductMapper productMapper = st.getMapper(ProductMapper.class);
		PageHelper.startPage(pn, size);
		List<Product> list = productMapper.getProList();
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		
		
		return pageInfo;
	}

	@Override
	public void delProduct(Product product) {
		ProductMapper mapper = st.getMapper(ProductMapper.class);
		 mapper.deleteByPrimaryKey(product.getProductId());
	}

	@Override
	public void addProduct(Product product) {
		ProductMapper mapper = st.getMapper(ProductMapper.class);
		 mapper.insert(product);
		
	}

	@Override
	public Product selProductById(Product product) {
		ProductMapper mapper = st.getMapper(ProductMapper.class);
		 Product selectByPrimaryKey = mapper.selectByPrimaryKey(product.getProductId());
		return selectByPrimaryKey;
	}

	@Override
	public void uptProduct(Product product) {
		ProductMapper mapper = st.getMapper(ProductMapper.class);
		 mapper.updateByPrimaryKeySelective(product);
		
	}

	@Override
	public PageInfo<Product> selProductList(int pn, int size,Product product) {
		ProductMapper Mapper = st.getMapper(ProductMapper.class);
		PageHelper.startPage(pn, size);
		List<Product> selProduct = Mapper.selProduct(product);
		
		PageInfo<Product> pageInfo = new PageInfo<Product>(selProduct);
		return pageInfo;
	}

	@Override
	public PageInfo<ProductMaterial> selProductMaterial(int pn, int size, String productId) {
		ProductMapper mapper = st.getMapper(ProductMapper.class);
		PageHelper.startPage(pn, size);
		List<ProductMaterial> selProductMaterial = mapper.selProductMaterial(productId);
		PageInfo<ProductMaterial> pageInfo = new PageInfo<ProductMaterial>(selProductMaterial);
		return pageInfo;
	}

	@Override
	public void delProductMaterial(ProductMaterial product) {
		ProductMaterialMapper mapper = st.getMapper(ProductMaterialMapper.class);
		mapper.deleteByPrimaryKey(product.getProductMaterialId());
		
	}

	@Override
	public void addProductMaterial(ProductMaterial product) {
		ProductMaterialMapper mapper = st.getMapper(ProductMaterialMapper.class);
		mapper.insert(product);
		
	}

	@Override
	public ProductMaterial updateProductMaterial(ProductMaterial productMaterial) {
		ProductMaterialMapper mapper = st.getMapper(ProductMaterialMapper.class);
		ProductMaterial selectByPrimaryKey = mapper.selectByPrimaryKey(productMaterial.getProductMaterialId());
		return selectByPrimaryKey;
	}

	@Override
	public void uptProductMaterial(ProductMaterial product) {
		ProductMaterialMapper mapper = st.getMapper(ProductMaterialMapper.class);
		mapper.updateByPrimaryKeySelective(product);
	}
	
	

}
