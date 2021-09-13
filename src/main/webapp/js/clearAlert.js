export const clearAlert = selector => {
    const alertInfo = document.querySelector(selector);
    setTimeout(() => {
        alertInfo?.parentNode.removeChild(alertInfo);
    }, 3000);
}