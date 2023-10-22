package com.example.kotliny.tp2
class University(var nom:String,var annee:Int) {
    val list_professeur = mutableListOf<Professeur>()
    val list_Student = mutableListOf<Stagaire>()

    fun hire(professeur: Professeur) {
        list_professeur.add(professeur)
    }

    fun enroll(stagaire: Stagaire) {
        list_Student.add(stagaire)
    }
}
//////////////professeur/////////////////////
class Professeur( var nom:String,var age:Int,var salaire:Int){
    val list_cours = mutableListOf<Course>()

    fun teach(course:Course){
        list_cours.add(course)
    }
    fun doOralExam(course:Course,stagaire: Stagaire) :Result{
        return  stagaire.grade(course)
    }
}
//////////////stagaire//////////////////////////////////
class Stagaire(var nom:String,var age:Int,var Matricule:Int){
    val list_cours = mutableListOf<Course>()
    var porcentagedecours :Double=0.0
    fun enroll(c:Course){
        list_cours.add(c)
    }
    fun takeExam(course:Course):Boolean{
        for (lecour in list_cours ){
            if(course==lecour){
                return true
            }
        }
        return false
    }
    fun learn(){
        if (porcentagedecours<1){
            porcentagedecours+=0.02

        }}
    fun party() {
        if (porcentagedecours>0){
            porcentagedecours-=0.02
        }}
    fun grade(course: Course):Result{
        if (takeExam(course)==true){
            if(porcentagedecours>=0.5){
                return Result.Admis
            }
            else  return Result.NonAdmis
        }
        return Result.NonAdmis
    }
}
/////////////////////course//////////////////////
class Course(var nomdecour:String){

}
/////////////////Result/////////////////////////
enum class Result{
    Admis,NonAdmis
}

fun main(){
    val university = University("NTIC SAFI", 2023)
    val professeur = Professeur("Madam Fadil", 36, 10000)
    val stagaire = Stagaire("Ihssane", 22, 12345)
    val course = Course("kotlin")

    university.hire(professeur)
    university.enroll(stagaire)

    professeur.teach(course)
    stagaire.enroll(course)

    for (i in 0..2){
        stagaire.party()
    }
    stagaire.enroll(course)
    for (i in 0..30) {
        stagaire.learn()
    }
    stagaire.takeExam(course)
    professeur.doOralExam(course,stagaire)

    println( professeur.doOralExam(course,stagaire))
}