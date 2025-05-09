package by.yumeinaruu.smb_integration.type

enum class DocumentType(private val message: String) {

    INTRODUCTION_TO_ASSISTANCE_SERVICES("Ознакомление с правилами оказания услуги"),
    CREDIT_HISTORY_AGREEMENT("Согласие на предоставление кредитного отчета"),
    LOAN_AGREEMENT("Ознакомление с договором займа"),
    PLEDGE_AGREEMENT("Ознакомление с договором залога"),
    EARLY_CLOSURE("Заявление на досрочное закрытие"),
    AML("Ознакомление с выдержками AML"),
    AML_SERVICE("Служебный AML"),
    SOCIAL_SECURITY_FUND_AGREEMENT("Согласие на предоставление отчета из ФСЗН"),
    NOTIFICATION_EXCEEDING_PERSONAL_DATA("Уведомления о получении займа с превышением ПДН");

    fun getMessage(): String {
        return "$message "
    }
}