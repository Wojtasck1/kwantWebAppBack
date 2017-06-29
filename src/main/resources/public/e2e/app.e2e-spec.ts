import { CarappfrontPage } from './app.po';

describe('carappfront App', () => {
  let page: CarappfrontPage;

  beforeEach(() => {
    page = new CarappfrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
