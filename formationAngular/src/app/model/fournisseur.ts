import { Personne } from './personne';
export class Fournisseur extends Personne {
  private _societe: string;

  public constructor(prenom?: string, nom?: string, societe: string = '') {
    super(prenom, nom);
    this._societe = societe;
  }

  /**
   * Getter societe
   * @return {string}
   */
  public get societe(): string {
    return this._societe;
  }

  /**
   * Setter societe
   * @param {string} value
   */
  public set societe(value: string) {
    this._societe = value;
  }
}
