export interface IPay {
  id?: number;
  cik?: string | null;
  ccc?: string | null;
  paymentAmount?: number | null;
  name?: string | null;
  email?: string | null;
  phone?: string | null;
  approval?: string | null;
}

export const defaultValue: Readonly<IPay> = {};
