export class User {
    constructor(
        public id: number,
        public email: string,
        public name: string,
         public joindate:Date,
        public location: string,
        public feedback: string,
        public institution: string,
        public contact: string,
        public cpp:string,
        public java:string,
        public python:string,
        public angular:string,
        public react:string,
        public javascript:string,
        public android:string,
        public jobDescription:string
        
        // public skills: string
    ){}
}