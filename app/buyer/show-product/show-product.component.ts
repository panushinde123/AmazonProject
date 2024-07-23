import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-show-product',
  templateUrl: './show-product.component.html',
  styleUrls: ['./show-product.component.css']
})
export class ShowProductComponent {


 
  carts:any;
  prods:any;
  cats: any;
  constructor(public http:HttpClient,public app:AppComponent)
  {
  let url2=app.baseUrl+'admin/getAll';
  http.get(url2).subscribe((data:any)=>{

    if(data==null)
    {
      window.alert('Something is Wrong')
    }
    else{
      this.cats=data;
    }

  });
}
addToCart(p:any) {
  let url=this.app.baseUrl+'buyer/getByProductandUsers'+p.id+'and'+this.app.id;;
  this.http.get(url).subscribe((data:any)=>{

if(data==null)
{
 window.alert('Something is Wrong')
}
else{
  console.log(p.id+" "+this.app.id);

 window.alert('Done');
 this.carts=data;
 
}
});

  }

updateRating(p:any) {
  let url3=this.app.baseUrl+'buyer/getRating'+p.id+'and'+this.app.id+'and'+p.stars;
     this.http.get(url3).subscribe((data:any)=>{

  if(data==null)
  {
    window.alert('Something is Wrong')
  }
  else if(data==0)
{
  window.alert("Already Added")
}
else{
  window.alert('Done');
  this.prods=data;
  this.showProducts();
  }
});
 
  }
  categoryid:number=0;
  minprice:number=0;
  maxprice:number=0;
  minrating:number=0;


  showProducts(){

    let obj=[this.categoryid,this.minprice,this.maxprice,this.minrating];
    let url=this.app.baseUrl+'buyer/getProductsByFilters';
     this.http.post(url,obj).subscribe((data:any)=>{

  if(data==null)
  {
    window.alert('Something is Wrong')
  }
  else{
    if(data==0)
    {
      window.alert('No Products Available In This Range')
    }
    this.prods=data;
    
  }
});
//console.log(this.categoryid,this.minprice,this.maxprice,this.minrating)



  }}