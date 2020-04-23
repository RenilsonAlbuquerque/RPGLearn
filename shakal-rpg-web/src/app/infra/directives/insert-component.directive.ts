import { Directive, ViewContainerRef, Input, ViewRef } from '@angular/core'

@Directive({
  selector: '[appInsertion]',
})
export class InsertionDirective {
  constructor(public viewContainerRef: ViewContainerRef) {}
  @Input()
  set view(view: ViewRef) {
    this.viewContainerRef.clear();
    this.viewContainerRef.insert(view);
  }

  ngOnDestroy() {
    this.viewContainerRef.clear()
  }
}