import { Component } from '@angular/core';
import {Log} from "./log";
import {LogService} from "./log.service";

@Component({
  selector: 'app-log-viewer',
  templateUrl: './log-viewer.component.html',
  styleUrls: ['./log-viewer.component.css']
})
export class LogViewerComponent {
  public allLogs: Log[] = [];
  public filteredLogs: Log[] = [];
  public selectedLogType: string;
  constructor(private logService: LogService) {
    this.selectedLogType = 'all';
  }
  ngOnInit() {
    this.logService.getLogs().subscribe(logs => {
      this.allLogs = logs;
      this.filteredLogs = logs;
    });

  }

  filterLogs() {
    if (this.selectedLogType === 'all') {
      this.filteredLogs = this.allLogs;
    } else if(this.selectedLogType === 'info') {
      this.logService.getInfoLogs().subscribe(logs => {
        this.filteredLogs = logs;
      });
    }
    else if(this.selectedLogType === 'error') {
      this.logService.getErrorLogs().subscribe(logs => {
        this.filteredLogs = logs;
      });
    }
    else if(this.selectedLogType === 'warning') {
      this.logService.getWarnLogs().subscribe(logs => {
        this.filteredLogs = logs;
      });
    }
    else if(this.selectedLogType === 'debug') {
      this.logService.getDebugLogs().subscribe(logs => {
        this.filteredLogs = logs;
      });
    }
  }
}
