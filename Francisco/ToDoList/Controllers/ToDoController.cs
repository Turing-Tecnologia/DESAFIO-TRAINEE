using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using ToDoList.Data;
using ToDoList.Models;

namespace ToDoList.Controllers
{
    public class ToDoController : Controller
    {
        /*Criando a variável do banco de dados, 
         * dei esse nome por ser um padrão na comunidade .NET
         */
        private readonly ToDoContext _context;

        //Conectando o context(Banco de dados) por meio da injeção de dependência
        public ToDoController(ToDoContext context)
        {
            _context = context;
        }

        /*Método que lista todas as tarefas mostrando primeiro as que não forafinalizadas,
         *por meio da função OrdeBy.
         */
        //Get: Todo/
        public async Task<IActionResult> Index()
        {
            return View(await _context.ToDo.OrderBy(t => t.Finished).ToListAsync());
        }

        //Método que mostra os detalhes da tarefa, por meio da sua ID.
        // GET: ToDo/Details/5
        public async Task<IActionResult> Details(long? id)
        {
            return await IDExiste(id);
        }

        //Método que chama a visão de cadastro
        // GET: ToDoes/Create
        public IActionResult Create()
        {
            return View();
        }

        //Método que recebe os dados da visão de cadastro
        // POST: ToDo/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("ID,Name,Description,Date")] ToDo dados)
        {   
            //Verificando se todos dados obrigátorios foram preenchidos
            if (ModelState.IsValid)
            {
                //Salvando no banco e retornando a visão de listagem
                _context.Add(dados);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }

            /*Caso os dados estejam errados a página é regarregada, 
             * com os memos dados para serem corrijidos.
             */
            return View(dados);
        }

        //Método que chama visão de edição para isso precisa verica se a ID existe
        // GET: ToDo/Edit/5
        public async Task<IActionResult> Edit(long? id)
        {
            return await IDExiste(id);
        }

        //Método que recebe os dados da visão da edição
        // POST: ToDoes/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(long? id, [Bind("ID,Name,Description,Date,Finished")] ToDo dados)
        {
            //Verifica se os dados estão corretos para poder realizar a autualização
            if (ModelState.IsValid)
            {
                //Caso os dados estejam corretos ele atualiza
                try
                {
                    _context.Update(dados);
                    await _context.SaveChangesAsync();
                }
                //Prevenção de erros na hora de atualizar 
                catch (DbUpdateConcurrencyException)
                {
                    if (!_context.ToDo.Any(e => e.ID == id))
                    {
                        return NotFound();
                    }
                }
                //Caso der tudo OK ele retornar para a visão listagem
                return RedirectToAction(nameof(Index));
            }
            /* Caso os dados estejam errados a página é regarregada, 
             * com os memos dados para serem corrijidos.
             */
            return View(dados);
        }

        //Método que chama visão de deletar para isso precisa verica se a ID existe
        // GET: ToDoes/Delete/5
        public async Task<IActionResult> Delete(long? id)
        {
            return await IDExiste(id);
        }

        //Método que deleta o registro do banco
        // POST: ToDo/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(long? id)
        {
            //Buscando o ID da tarefa no banco e exluindo
            var id_tarefa = await _context.ToDo.FindAsync(id);
            _context.ToDo.Remove(id_tarefa);
            await _context.SaveChangesAsync();

            //Redirecionando para a visão listagem
            return RedirectToAction(nameof(Index));
        }


        //Método que verifica se a tarefa existe pela ID
        private async Task<IActionResult> IDExiste(long? id)
        {
            //Verificação se foi passada a ID pela URL
            if (id == null)
            {
                return NotFound();
            }

            //Vericando se a ID existe no banco de dados
            var id_existe = await _context.ToDo.FirstOrDefaultAsync(m => m.ID == id);
            if (id_existe == null)
            {
                return NotFound();
            }

            //Retornando a visão com a ID da tarefa
            return View(id_existe);
        }
    }
}
