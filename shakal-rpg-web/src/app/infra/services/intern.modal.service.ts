import { Injectable, TemplateRef } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Injectable()
export class InternModalService {

    private modalReference;
    constructor(private modalService: NgbModal){
    }

    openExtraLargeModal(content:TemplateRef<any>) {
        this.modalReference = this.modalService.open(content, {size: 'xl'});
    }
    openLargeModal(content:TemplateRef<any>) {
        this.modalReference = this.modalService.open(content, {size: 'lg'});
    }
}