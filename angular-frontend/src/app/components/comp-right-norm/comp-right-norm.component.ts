import {Component, OnInit} from '@angular/core';
import {CompRightNormService} from '../../services/comp-right-norm.service';
import {Router} from '@angular/router';
import {Company} from '../../models/company';
import {CompRightNorm} from '../../models/comp-right-norm';

@Component({
  selector: 'app-comp-right-norm',
  templateUrl: './comp-right-norm.component.html',
  styleUrls: ['./comp-right-norm.component.css']
})
export class CompRightNormComponent implements OnInit {

  private crnServ: CompRightNormService;
  private router: Router;

  crn: CompRightNorm[];

  selectedCRNValue: CompRightNorm;
  nameCRN: string;
  changedCRNId: number;

  // isLoading: boolean = false;

  constructor(
    crn: CompRightNormService,
    r: Router) {
    this.crnServ = crn;
    this.router = r;
  }

  ngOnInit(): void {
    this.reloadData();
  }

  private reloadData(): void {
    this.crnServ.getCompRightNormList().subscribe(value => {
      value = JSON.parse(value);
      this.crn = value as Company[];
      console.log(this.crn);
    });
  }


  deleteCRN(id: number): void {
    console.log(id);
    // this.isLoading = true;
    this.crnServ.delCompRightNormById(id).subscribe(value => {
        const temp = this.crn.find(item => item.id === id);
        this.crn.forEach((item, index, array) => {
          if (item == temp) {
            array.splice(index, 1);
          }
        });
        // this.isLoading = false;

      }, error => console.error(error),
      () => {
        // this.isLoading = false;
      });

    //this.reloadData();

  }

  openAddModal(): void {
    this.selectedCRNValue = new CompRightNorm();
    this.nameCRN = '';
  }

  openEditModal(id: number): void {
    console.log(id);
    this.selectedCRNValue = this.crn.find(value => value.id === id);
    this.nameCRN = this.selectedCRNValue.name;
    this.changedCRNId = this.selectedCRNValue.id;
  }

  saveChanges(): void {
    this.selectedCRNValue.name = this.nameCRN;
    console.log(this.selectedCRNValue);
    this.crnServ.saveCompRightNorm(this.selectedCRNValue).subscribe(value => {
      console.log(value);
      this.reloadData();
    });
  }


}
