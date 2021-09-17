import {
    EDIT_PUBLICATION,
    DELETE_PUBLICATION,
    language
} from './constants.js';

export const removeConfirm = selector => {
    const publicationTable = document?.querySelector(selector);
    publicationTable?.addEventListener('click', e => {
        e.preventDefault();
        const {btn} = e.target.dataset;
        const {id} = e.target;
        const {lang} = document.documentElement;
        if (btn === 'editBtn') {
            location.href = `${EDIT_PUBLICATION}&id=${id}`
        } else if (btn === 'removeBtn') {
            const question = lang === 'ru' ? language[lang] : language['en'];
            const isRemove = confirm(question);
            if (isRemove) {
                location.href = `${DELETE_PUBLICATION}&id=${id}`;
            }
        }
    })
}