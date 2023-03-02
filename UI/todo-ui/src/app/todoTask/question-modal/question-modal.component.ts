import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-question-modal',
  templateUrl: './question-modal.component.html',
  styleUrls: ['./question-modal.component.css']
})
export class QuestionModalComponent {

  title:String;

  constructor(public dialogRef: MatDialogRef<QuestionModalComponent>, @Inject(MAT_DIALOG_DATA) public data: String) {
    this.title = data;
  }

    close(closeType:boolean){
    this.dialogRef.close(closeType);
    }
}
