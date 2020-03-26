using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ToDoList.Models;

namespace ToDoList.Data
{
    public class ToDoContext : DbContext
    {
        //Método construtor
        public ToDoContext(DbContextOptions options) : base(options)
        {
        }

        //Configurar o banco de dados a partir do modelo ToDo
        public DbSet<ToDo> ToDo { get; set; }
    }
}
