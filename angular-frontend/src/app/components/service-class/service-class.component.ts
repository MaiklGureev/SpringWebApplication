import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ServiceClass} from '../../models/sc';
import {ServiceClassService} from '../../services/service-class.service';
import {ServiceSection} from '../../models/ss';
import {ServiceSectionService} from '../../services/service-section.service';

@Component({
  selector: 'app-service-class',
  templateUrl: './service-class.component.html',
  styleUrls: ['./service-class.component.css']
})
export class ServiceClassComponent implements OnInit {

  private scServ: ServiceClassService;
  private ssServ: ServiceSectionService;
  private router: Router;
  serviceClasses: ServiceClass[];
  serviceSections: ServiceSection[];
  selectedSSValue: ServiceSection;
  selectedSCValue: ServiceClass;


  codeSC: string;
  descriptionSC: string;
  serviceSection: ServiceSection;
  changedSCId: number;
  changedSSId: number;


  // isLoading: boolean = false;

  constructor(scs: ServiceClassService,
              sss: ServiceSectionService,
              r: Router) {
    this.ssServ = sss;
    this.scServ = scs;
    this.router = r;
  }

  ngOnInit(): void {
    this.reloadData();
  }

  private reloadData(): void {

    this.ssServ.getServiceSectionList().subscribe(value => {
      value = JSON.parse(value);
      this.serviceSections = value as ServiceSection[];
      console.log(this.serviceSections);
    });

    this.scServ.getServiceClassList().subscribe(value => {
      value = JSON.parse(value);
      this.serviceClasses = value as ServiceClass[];
      console.log(this.serviceClasses);
    });

  }

  deleteServiceClass(id: number): void {
    console.log(id);
    // this.isLoading = true;
    this.scServ.delServiceClassById(id).subscribe(value => {
        const temp = this.serviceClasses.find(item => item.id === id);
        this.serviceClasses.forEach((item, index, array) => {
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
    this.selectedSCValue = new ServiceClass();
    this.selectedSCValue.serviceSection = this.serviceSections[0];
    this.changedSSId = 0;
    this.descriptionSC = '';
    this.codeSC = '';
  }

  openEditModal(id: number): void {
    console.log(id);
    this.selectedSCValue = this.serviceClasses.find(value => value.id === id);
    this.selectedSSValue = this.selectedSCValue.serviceSection;
    this.codeSC = this.selectedSCValue.code;
    this.descriptionSC = this.selectedSCValue.description;
    this.changedSCId = this.selectedSCValue.id;
    this.changedSSId = this.selectedSSValue.id;
    //this.serviceSection = this.selectedSCValue.;
  }

  saveChanges(): void {
    this.selectedSCValue.code = this.codeSC;
    this.selectedSCValue.description = this.descriptionSC;
    this.serviceSections.find(value => {
      if (value.id == this.changedSSId) {
        this.selectedSCValue.serviceSection = value;
      }
    });
    console.log(this.selectedSCValue);
    this.scServ.saveServiceClass(this.selectedSCValue).subscribe(value => {
      console.log(value);
      this.reloadData();
    });
  }


}
