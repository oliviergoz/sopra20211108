import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'demo',
})
export class DemoPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): unknown {
    return value.length <= 5 ? value : value.substring(0, 5) + '...';
  }
}
