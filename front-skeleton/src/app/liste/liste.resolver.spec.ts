import { TestBed } from '@angular/core/testing';
import { ResolveFn } from '@angular/router';

import { listeResolver } from './liste.resolver';

describe('listeResolver', () => {
  const executeResolver: ResolveFn<boolean> = (...resolverParameters) => 
      TestBed.runInInjectionContext(() => listeResolver(...resolverParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeResolver).toBeTruthy();
  });
});
