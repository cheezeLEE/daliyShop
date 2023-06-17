// javascript 공통코드

/* 암호화 변수 */
var secretKey = "0123456789abcdef0123456789abcdef"; // key 값 32 바이트
var Iv = ""; //iv 16 바이트
var aes256EncodeData = "";
var aes256DecodeData = "";

/* AES256 암호화 */
function passwordEncoding(data){
    console.log("");
    console.log("[aes256Encode] : [start]");
    console.log("[secretKey] : " + secretKey);
    console.log("[Iv] : " + Iv);
    console.log("[data] : " + data);
    console.log("");

    // [aes 인코딩 수행 실시 : cbc 모드]
    const cipher = CryptoJS.AES.encrypt(data, CryptoJS.enc.Utf8.parse(secretKey), {
        iv: CryptoJS.enc.Utf8.parse(Iv), // [Enter IV (Optional) 지정 방식]
        padding: CryptoJS.pad.Pkcs7,
        mode: CryptoJS.mode.CBC // [cbc 모드 선택]
    });

    // [인코딩 된 데이터 확인 실시]
    aes256EncodeData = cipher.toString();
    console.log("");
    console.log("[aes256Encode] : [encode]");
    console.log("[data] : " + aes256EncodeData);
    console.log("");

    return aes256EncodeData;
};

/* AES256 복호화 */
function passwordDecoding(data){
    console.log("");
    console.log("[aes256Decode] : [start]");
    console.log("[secretKey] : " + secretKey);
    console.log("[Iv] : " + Iv);
    console.log("[data] : " + data);
    console.log("");

    // [aes 디코딩 수행 실시 : cbc 모드]
    const cipher = CryptoJS.AES.decrypt(data, CryptoJS.enc.Utf8.parse(secretKey), {
        iv: CryptoJS.enc.Utf8.parse(Iv), // [Enter IV (Optional) 지정 방식]
        padding: CryptoJS.pad.Pkcs7,
        mode: CryptoJS.mode.CBC // [cbc 모드 선택]
    });

    // [인코딩 된 데이터 확인 실시]
    aes256DecodeData = cipher.toString(CryptoJS.enc.Utf8);
    console.log("");
    console.log("[aes256Decode] : [decode]");
    console.log("[data] : " + aes256DecodeData);
    console.log("");

    return aes256DecodeData;
};
