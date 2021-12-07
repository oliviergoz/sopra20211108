import { Civilite } from './civilite';
export class Client {
  public constructor(
    private _id?: number | undefined,
    private _prenom?: string | undefined,
    private _nom?: string | undefined,
    private _civilite?: Civilite | undefined,
    private _login?: string | undefined
  ) {}

  /**
   * Getter id
   * @return {number}
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter prenom
   * @return {string}
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter civilite
   * @return {Civilite}
   */
  public get civilite(): Civilite | undefined {
    return this._civilite;
  }

  /**
   * Getter login
   * @return {string}
   */
  public get login(): string | undefined {
    return this._login;
  }

  /**
   * Setter id
   * @param {number} value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter prenom
   * @param {string} value
   */
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter civilite
   * @param {Civilite} value
   */
  public set civilite(value: Civilite | undefined) {
    this._civilite = value;
  }

  /**
   * Setter login
   * @param {string} value
   */
  public set login(value: string | undefined) {
    this._login = value;
  }
}
