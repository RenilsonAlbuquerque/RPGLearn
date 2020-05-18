export const convertFileToBase64 = (file : File) => new Promise((resolve, reject) => {
    //let file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => resolve(reader.result);
    reader.onerror = error => reject(error);
})