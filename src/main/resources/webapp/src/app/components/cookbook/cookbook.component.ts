import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cookbook',
  templateUrl: './cookbook.component.html',
  styleUrls: ['./cookbook.component.css']
})
export class CookbookComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  addRecipe(){
    window.alert("home")
    var x = document.getElementById("recipeList")
    var box = document.createElement('input')
    x.append(box)
  }

}
