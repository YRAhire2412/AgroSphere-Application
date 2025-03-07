package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ProductEntityDao;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
@Autowired
ProductEntityDao productEntityDao;

@Override
public List<Product> getProducts() {
	return productEntityDao.findAll();
}

@Override
public Product getProductById(Long id) {
    return productEntityDao.findById(id).orElse(null);
}

@Override
public String addProduct(Product product) {
	productEntityDao.save(product);
    return "Product added successfully";
}

@Override
public String updateProduct(Product obj , Long id) {
		
	if(productEntityDao.existsById(id)) 
	{
		Product prod = productEntityDao.findById(id).get();
		
		prod.setProd_name(obj.getProd_name());
		prod.setProd_qty(obj.getProd_qty());
		prod.setProd_description(obj.getProd_description());
		prod.setMarket(obj.getMarket());
		
        productEntityDao.save(prod);
        return "Product updated successfully";
    
	} 
	
    return "Product not found";  
}

@Override
public String deleteProduct(Long id) {
	if(productEntityDao.existsById(id)) {
        productEntityDao.deleteById(id);
        return "Product deleted successfully";
    } else {
        return "Product not found";   }
}

}
