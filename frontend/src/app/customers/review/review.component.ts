import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';
import { SharedServiceService } from '../shared-service.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  constructor(private ss:SharedServiceService,private cs:CustomerServiceService,
    private router:Router) { }
  
  name='';
	email='';
	subject='';
	ratings='';
  des=''
  ngOnInit(): void {
  }
  
  feedback(): void{
    var feedback = {
      name: this.name,
      email: this.email,
      subject:this.subject,
      ratings:this.ratings,
      des:this.des
    };
    this.cs.getfeedback(feedback).subscribe(
      feedback => {
        console.log(feedback);
      }
    )

    this.cs.sendfeedback(feedback).subscribe(
      feedback => {
        this.feedback = feedback;
        console.log(feedback);
      }
    )

    this.cs.sendOrderEmail(feedback).subscribe(
      feedback => {
        this.feedback = feedback;
        console.log(feedback);
      }
    ) 

    alert(`Your Feedback has been submitted successfully. \n Please check your email for the Order confirmation`);

    this.router.navigate(['customers/products']);
  }

}
