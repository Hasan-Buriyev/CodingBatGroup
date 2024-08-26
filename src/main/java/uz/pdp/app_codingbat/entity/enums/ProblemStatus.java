package uz.pdp.app_codingbat.entity.enums;

public enum ProblemStatus {
    ACCEPTED ,//"Yechim barcha sinov holatlaridan muvaffaqiyatli o'tdi.
    WRONG_ANSWER, //"Yechim ba'zi sinov holatlari uchun kutilgan natijani qaytarmadi.
    TIME_LIMIT_EXCEEDED,//Yechim belgilangan vaqt ichida bajarilmadi.,
    MEMORY_LIMIT_EXCEEDED,//Yechim belgilangan xotira miqdoridan ko'proq foydalanib yubordi.,
    RUNTIME_ERROR,//Yechim ishlashi davomida xatolik yuz berdi, masalan, nolga bo'lish yoki massiv chegarasidan chiqish.,
    COMPILE_ERROR,//Yechimni kompilyatsiya qilishda xatolik yuz berdi, masalan, sintaksis xatosi.
}
