using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ToDoList.Models
{
    //Criação do Modelo para o banco de dados.
    public class ToDo
    {
        
        public long? ID { get; set; }

        //O campo nome é obrigatório e é do tipo texto.
        [Required(ErrorMessage = "O campo tarefa é necessário")]
        [Display(Name = "Tarefa")]
        [DataType(DataType.Text)]
        public string Name { get; set; }

        //O campo descrição é obrigatória, no máximo de 150 caracteres e é do tipo multípla linhas.
        [Required(ErrorMessage = "O campo descrição é necessário")]
        [Display(Name = "Descrição")]
        [StringLength(150, ErrorMessage = "O campo só aceita 150 caracteres")]
        [DataType(DataType.MultilineText)]
        public string Description { get; set; }

        //O campo data é obrigatória e é do tipo Data e Hora.
        [Required]
        [Display(Name = "Data da criação")]
        [DataType(DataType.Date)]
        public DateTime Date { get; set; }

        //O campo concluído é opcional e é do Verdairo ou falso
        [Display(Name = "Concluído?")]
        public bool Finished { get; set; }

    }
}
