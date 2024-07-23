import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
list:any;
list1:any;
constructor(public http:HttpClient,public app:AppComponent)
{
  let url=app.baseUrl+'seller/getAllProducts'+app.id;
  http.get(url).subscribe((data:any)=>{
    if(data==null)
    {
      window.alert('Something is Wrong')
    }
    else{
      this.list=data;
    }
  });
  

  let url2=app.baseUrl+'admin/getAll';
  http.get(url2).subscribe((data:any)=>{

    if(data==null)
    {
      window.alert('Something is Wrong')
    }
    else{
      this.list1=data;
    }

  });
}
loadProducts()
{
  let url=this.app.baseUrl+'seller/getAllProducts'+this.app.id;
  this.http.get(url).subscribe((data:any)=>{
    if(data==null)
    {
      window.alert('Something is Wrong')
    }
    else{
      this.list=data;
    }
  });
}


name:string='';
date:any='';
price:string='';
quantity:number=0;
description:string='';
rating:number=0;
discount:number=0;
catid:number=0;

addProduct(){
  let product={
    "name":this.name,
    "date":this.date,
    "userid":this.app.id,
    "price":this.price,
    "quantity":this.quantity,
    "description":this.description,
    "rating":this.rating,
    "discount":this.discount,
    "categoryid":this.catid
  };
  let url=this.app.baseUrl+'seller/addNewProduct';
this.http.post(url,product).subscribe((data:any)=>{

  if(data==null)
  {
    window.alert('Something is Wrong')
  }
  else{
    this.list.push(data);
    this.loadProducts();
    this.name='';
    this.price='';
    this.description='';
    this.quantity=0;
    this.discount=0;
  }
});}
}


