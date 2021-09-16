import {validateForm} from './validateForm.js';
import {removeConfirm} from './removeConfirm.js';
import {changeActiveLink} from './changeActiveLink.js';

console.log(`%cInit App`, `color: lime;`);

validateForm('.needs-validation');

removeConfirm('#publicationTableBody');

changeActiveLink('.page-item');
