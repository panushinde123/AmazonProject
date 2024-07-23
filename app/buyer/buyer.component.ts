import { Component } from '@angular/core';

@Component({
  selector: 'app-buyer',
  templateUrl: './buyer.component.html',
  styleUrls: ['./buyer.component.css']
})
export class BuyerComponent {
  whatToshow:number=0;
  changewhatToshow(num:number)
  {
    this.whatToshow=num;
  }
  
}
