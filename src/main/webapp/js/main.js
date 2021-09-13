import { validateForm } from './validateForm.js';
import { clearAlert } from './clearAlert.js';

console.log(`%cInit App`, `color: lime;`);

validateForm('.needs-validation');

clearAlert('info');


