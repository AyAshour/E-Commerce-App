import { Component, OnInit } from '@angular/core';
import {BrandService} from "../services/brand/brand.service";
import {CategoryService} from "../services/category/category.service";
import {ProductService} from "../services/product/product.service";

@Component({
  selector: 'app-add-product-to-system',
  templateUrl: './add-product-to-system.component.html',
  styleUrls: ['./add-product-to-system.component.css']
})
export class AddProductToSystemComponent implements OnInit {
  public brands: any[];
  public categories: any[];
  public choosenCategory : any = null;
  public choosenBrand : any = null;
  public product = {
    "name" : "",
    "priceRange" : "",
    "price" : 0,
    "categoryId" : 0,
    "brandId" : 0,
    "inStock" : 1
  }
  private response;

  constructor(private brandService: BrandService, private categoryService: CategoryService, private productService: ProductService ) { }

  ngOnInit() {
    this.brandService.getBrands().subscribe(brands => this.brands = brands);
    this.categoryService.getCategories().subscribe(categories => this.categories = categories);
  }

  addProduct(){
    this.product.brandId = this.choosenBrand.id;
    this.product.categoryId = this.choosenCategory.id;
    this.productService.addProductToSystem(this.product).subscribe(response => {
      console.log(response);
      this.response = response;
    });
  }
}
