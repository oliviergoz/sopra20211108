export class Produit {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _description?: string | undefined,
    private _prix?: number | undefined
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter description
   * @return {string }
   */
  public get description(): string | undefined {
    return this._description;
  }

  /**
   * Getter prix
   * @return {number }
   */
  public get prix(): number | undefined {
    return this._prix;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter description
   * @param {string } value
   */
  public set description(value: string | undefined) {
    this._description = value;
  }

  /**
   * Setter prix
   * @param {number } value
   */
  public set prix(value: number | undefined) {
    this._prix = value;
  }

  
}
