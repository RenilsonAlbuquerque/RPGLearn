import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-coin-icon',
  templateUrl: './coin-icon.component.html',
  styleUrls: ['./coin-icon.component.scss']
})
export class CoinIconComponent implements OnInit {

  @Input()
  public coinType: number;

  @Input()
  public value: number;
  constructor() { }

  ngOnInit() {
  }

}
