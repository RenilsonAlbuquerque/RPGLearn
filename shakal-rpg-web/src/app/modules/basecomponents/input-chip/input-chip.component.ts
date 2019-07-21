import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {Component, ElementRef, ViewChild, Input} from '@angular/core';
import {FormControl} from '@angular/forms';
import { MatAutocomplete, MatAutocompleteSelectedEvent} from '@angular/material/autocomplete';
import {MatChipInputEvent} from '@angular/material/chips';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { KeyValue } from 'src/app/domain/models/comon/key.value';




@Component({
  selector: 'app-input-chip',
  templateUrl: './input-chip.component.html',
  styleUrls: ['./input-chip.component.scss']
})
export class InputChipComponent {

  @Input() placeholderComponent: string;
  @Input() allElements: KeyValue[] = [];
  @Input() elementControl = new FormControl();

  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  public chipSelectedElements: KeyValue[] = [];
  public filteredElements: Observable<String[]>;
  
  private allowFreeTextAddEngineer = false;

  @ViewChild('elementInput', {static: false}) elementInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto', {static: false}) matAutocomplete: MatAutocomplete;

  constructor() {
    
    this.filteredElements = this.elementControl.valueChanges.pipe(
      startWith(null),
      map(elementValue => this.filterOnValueChange(elementValue))
    );
    
  }

  public addElement(event: MatChipInputEvent): void {
    if (!this.allowFreeTextAddEngineer) {
      // only allowed to select from the filtered autocomplete list
      console.log('allowFreeTextAddEngineer is false');
      return;
    }
    //
    // Only add when MatAutocomplete is not open
    // To make sure this does not conflict with OptionSelected Event
    //
    if (this.matAutocomplete.isOpen) {
      return;
    }

     // Add our engineer
     const value = event.value;
     if ((value || '').trim()) {
      this.selectEngineerByName(value.trim());
    }

    this.resetInputs();
  }
  public removeElement(element: KeyValue): void {
    const index = this.chipSelectedElements.indexOf(element);
    if (index >= 0) {
      this.chipSelectedElements.splice(index, 1);
      this.resetInputs();
    }
  }
  private resetInputs() {
    // clear input element
    this.elementInput.nativeElement.value = '';
    // clear control value and trigger engineerControl.valueChanges event 
    this.elementControl.setValue(null); 
  }
  public elementSelected(event: MatAutocompleteSelectedEvent): void {
    this.selectEngineerByName(event.option.value);
    this.resetInputs();
  }
  private filterOnValueChange(engineerName: string | null): String[] {
    let result: String[] = [];
    //
    // Remove the engineers we have already selected from all engineers to
    // get a starting point for the autocomplete list.
    //
    let allEngineersLessSelected = this.allElements.filter(engineer => this.chipSelectedElements.indexOf(engineer) < 0);
    if (engineerName) {
      result = this.filterEngineer(allEngineersLessSelected, engineerName);
    } else {
      result = allEngineersLessSelected.map(element => element.value);
    }
    return result;
  }
  private filterEngineer(engineerList: KeyValue[], engineerName: String): String[] {
    let filteredEngineerList: KeyValue[] = [];
    const filterValue = engineerName.toLowerCase();
    let engineersMatchingEngineerName = engineerList.filter(engineer => engineer.value.toLowerCase().indexOf(filterValue) === 0);
    if (engineersMatchingEngineerName.length || this.allowFreeTextAddEngineer) {
      //
      // either the engineer name matched some autocomplete options 
      // or the name didn't match but we're allowing 
      // non-autocomplete engineer names to be entered
      //
      filteredEngineerList = engineersMatchingEngineerName;
    } else {
      //
      // the engineer name didn't match the autocomplete list 
      // and we're only allowing engineers to be selected from the list
      // so we show the whjole list
      // 
      filteredEngineerList = engineerList;
    }
    //
    // Convert filtered list of engineer objects to list of engineer 
    // name strings and return it
    //
    return filteredEngineerList.map(element => element.value);
  }
  private selectEngineerByName(elementValue) {
    let foundElement = this.allElements.filter(element => element.value == elementValue);
    if (foundElement.length) {
      //
      // We found the engineer name in the allEngineers list
      //
      this.chipSelectedElements.push(foundElement[0]);
    } else {
      //
      // Create a new engineer, assigning a new higher employeeId
      // This is the use case when allowFreeTextAddEngineer is true
      //
      let highestElementId = Math.max(...this.chipSelectedElements.map(element => element.id), 0);
      this.chipSelectedElements.push({ value: elementValue, id: highestElementId + 1 });
    }
  }

 
}