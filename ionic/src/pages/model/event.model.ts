class Event{

    constructor(public id:number,public nom:string, public adresse:string, public tarif:string,
        public dateDebut:string, public dateFin:string, public validation:number,public utilisateurId:number){

        }

} export default Event;