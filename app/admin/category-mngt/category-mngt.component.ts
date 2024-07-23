import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-category-mngt',
  templateUrl: './category-mngt.component.html',
  styleUrls: ['./category-mngt.component.css']
})
export class CategoryMngtComponent {
list:any;
constructor(public http:HttpClient,public app:AppComponent)
{
  let url=app.baseUrl+'admin/getAll';
  http.get(url).subscribe((data:any)=>{

    if(data==null)
    {
      window.alert('Something is Wrong')
    }
    else{
      this.list=data;
    }

  });
}
categoryid:number=0;
name:string='';
// userid:number=0;

  addCategory()
  {
    let category={
      "name":this.name,
      // "userid":this.userid
    }
let url=this.app.baseUrl+'admin/addNew'+this.app.id;
this.http.post(url,category).subscribe((data:any)=>{

  if(data==null)
  {
    window.alert('Something is Wrong')
  }
  else{
    this.list.push(data);
    this.name='';
  }
});
  }

}
