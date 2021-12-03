import { Produit } from './produit';
import { Personne } from './personne';
export class Client extends Personne {
  private _CA: number = 0;
  private _produits: Produit[] = [];

  constructor(prenom?: string, nom?: string, CA: number = 0) {
    super(prenom, nom);
    this._CA = CA;
  }

  /**
   * Getter CA
   * @return {number }
   */
  public get CA(): number {
    return this._CA;
  }

  /**
   * Setter CA
   * @param {number } value
   */
  public set CA(value: number) {
    this._CA = value;
  }

  /**
   * Getter produits
   * @return {Produit[] }
   */
  public get produits(): Produit[] {
    return this._produits;
  }

  /**
   * Setter produits
   * @param {Produit[] } value
   */
  public set produits(value: Produit[]) {
    this._produits = value;
  }
}
