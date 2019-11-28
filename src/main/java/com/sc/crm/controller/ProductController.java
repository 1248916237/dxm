package com.sc.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Product;
import com.sc.crm.bean.ProductMaterial;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.service.ProductService;

@Controller
public class ProductController {
	
	@Resource
	private ProductService productservice;

	
	@RequestMapping("/getProduct")
	public String getProductList(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			Map<String, Object> data
			){
				PageInfo<Product> pageInfo = productservice.getProductList(pn, size);
				data.put("pageinfo", pageInfo);
		return "forward:/product.jsp";	
	}
	
	
	
	@RequestMapping("/delProduct")
	@ResponseBody
	public ResultBean delProduct(Product product){
		productservice.delProduct(product);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	
	@RequestMapping("/addProduct")
	@ResponseBody
	public ResultBean addProduct(Product product){
		productservice.addProduct(product);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	@RequestMapping("/updateProduct")
	public String selProductById(Product product,Map<String, Object> data){
		Product pro = productservice.selProductById(product);
		data.put("p", pro);
		return "forward:/updateproduct.jsp";
		}
	
	@RequestMapping("/updatepro")
	@ResponseBody
	public ResultBean uptProduct(Product product){
		productservice.uptProduct(product);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	@RequestMapping("/selProduct")
	public String selProductList(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			Product product,
			Map<String, Object> data
			){
				PageInfo<Product> selProductList = productservice.selProductList(pn, size, product);
				data.put("pageinfo", selProductList);
				System.out.println(product);
		return "forward:/product.jsp";	
	}
	
	@RequestMapping("/selProductMaterial")
	public String selProductMaterial(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			String productId,
			Map<String, Object> data
			){
				PageInfo<ProductMaterial> selProductMaterial = productservice.selProductMaterial(pn, size, productId);
				data.put("pageinfo", selProductMaterial);
				data.put("productId", productId);
		return "forward:/productmaterial.jsp";	
	}
	
	
	
	@RequestMapping("/delProductMaterial")
	@ResponseBody
	public ResultBean delProductMaterial(ProductMaterial product){
		
		productservice.delProductMaterial(product);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	

	@RequestMapping("/addProductMaterial")
	@ResponseBody
	public ResultBean addProductMaterial(ProductMaterial product){
		productservice.addProductMaterial(product);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	@RequestMapping("/updateProductMaterial")
	public String updateProductMaterial(ProductMaterial productMaterial,
			Map<String, Object> data
			){
		ProductMaterial updateProductMaterial = productservice.updateProductMaterial(productMaterial);
		data.put("p", updateProductMaterial);
		return "forward:/updateproductmaterial.jsp";	
	}
	
	@RequestMapping("/uptProductMaterial")
	@ResponseBody
	public ResultBean uptProductMaterial(ProductMaterial product){
		productservice.uptProductMaterial(product);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	
	
	
}
