package id.ac.polbeng.wawansaputra.fragmentexample2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.ac.polbeng.wawansaputra.fragmentexample2.databinding.BookDescriptionBinding

class BookDescription : Fragment() {
    private var _binding: BookDescriptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var arrBookDesc: Array<String>
    private var bookIndex = 0

    override
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookDescriptionBinding.inflate(
            inflater,
            container,
            false
        )

        arrBookDesc = resources . getStringArray (R.array.book_descriptions)
        if (savedInstanceState != null) {
            bookIndex = savedInstanceState.getInt("bookIndex", 0); }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bookIndex", bookIndex)
        super.onSaveInstanceState(outState)
    }

    fun changeDescription(index: Int) {
        bookIndex = index
        binding.tvDescription.text = arrBookDesc [bookIndex]
        println ("BOOK INDEX = $bookIndex")
        println (arrBookDesc[bookIndex])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}