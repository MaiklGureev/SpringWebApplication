import {Component, OnInit} from '@angular/core';
import {ServiceSectionService} from '../../services/service-section.service';
import {Router} from '@angular/router';
import {ServiceSection} from '../../models/ss';

@Component({
  selector: 'app-service-section',
  templateUrl: './service-section.component.html',
  styleUrls: ['./service-section.component.css']
})
export class ServiceSectionComponent implements OnInit {

  private ssServ: ServiceSectionService;
  private router: Router;
  serviceSections: ServiceSection[];
  selectedSSValue: ServiceSection;


  nameSS: string;
  changedSSId: number;

  // isLoading: boolean = false;

  constructor(sss: ServiceSectionService,
              r: Router) {
    this.ssServ = sss;
    this.router = r;
  }

  ngOnInit(): void {
    this.reloadData();
  }

  private reloadData(): void {

    this.ssServ.getServiceSectionList().subscribe(value => {
      value = JSON.parse(value);
      this.serviceSections = value as ServiceSection[];
      //console.log(this.serviceSections);
    });
  }

  deleteServSection(id: number): void {
    console.log(id);
    // this.isLoading = true;
    this.ssServ.delServiceSectionById(id).subscribe(value => {
        const temp = this.serviceSections.find(item => item.id === id);
        this.serviceSections.forEach((item, index, array) => {
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
    this.selectedSSValue = new ServiceSection();
    this.nameSS = '';
  }

  openEditModal(id: number): void {
    console.log(id);
    this.selectedSSValue = this.serviceSections.find(value => value.id === id);
    this.nameSS = this.selectedSSValue.name;
    this.changedSSId = this.selectedSSValue.id;
  }

  saveChanges(): void {
    this.selectedSSValue.name = this.nameSS;
    console.log(this.selectedSSValue);
    this.ssServ.saveServiceSection(this.selectedSSValue).subscribe(value => {
      console.log(value);
      this.reloadData();
    });
  }

}
