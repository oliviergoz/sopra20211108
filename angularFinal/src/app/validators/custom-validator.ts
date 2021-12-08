import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidator {
  public static pasOlivier(control: AbstractControl): ValidationErrors | null {
    // if(control.value=='olivier'){
    //   return {pasOlivier:true};
    // }else{
    //   return null;
    // }
    return control.value == 'olivier' ? { pasOlivier: true } : null;
  }

  public static pasTexte(texte: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == texte ? { pasTexte: true } : null;
    };
  }
}
