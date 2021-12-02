import { Fournisseur } from './fournisseur';
export class Produit {
  private _nom: string;
  private _prix: number;
  private _fournisseur: Fournisseur | null = null;

  public constructor(
    nom: string = '',
    prix: number = 0,
    fournisseur: Fournisseur | null = null
  ) {
    this._nom = nom;
    this._prix = prix;
    this._fournisseur = fournisseur;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter prix
   * @return {number}
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Getter fournisseur
   * @return {Fournisseur }
   */
  public get fournisseur(): Fournisseur | null {
    return this._fournisseur;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter prix
   * @param {number} value
   */
  public set prix(value: number) {
    this._prix = value;
  }

  /**
   * Setter fournisseur
   * @param {Fournisseur } value
   */
  public set fournisseur(value: Fournisseur | null) {
    this._fournisseur = value;
  }
}
