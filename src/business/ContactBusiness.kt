package business

import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {
    fun save(name :String, phone :String){
        validate(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun remove(name: String, phone: String){
        validadeRemove(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.remove(contact)
    }

    fun validate(name: String, phone: String){
        if(name == ""){
            throw Exception("Nome é obrigatório!")

        }
        if(phone == ""){
            throw java.lang.Exception("Telefone é obrigatório!")
        }
    }

    fun validadeRemove(name: String, phone: String){
        if(name == "" || phone == ""){
            throw java.lang.Exception("Selecione um contato primeiro!")
        }
    }
}