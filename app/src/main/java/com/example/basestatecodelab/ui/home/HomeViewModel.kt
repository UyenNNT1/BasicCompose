package com.example.basestatecodelab.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basestatecodelab.R
import com.example.basestatecodelab.data.BannerModel
import com.example.basestatecodelab.data.CategoryModel
import com.example.basestatecodelab.data.DataItem
import com.example.basestatecodelab.data.ToolModel
import com.example.basestatecodelab.data.ToolStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _tools = MutableStateFlow<List<ToolModel>>(emptyList())
    val tool = _tools.asStateFlow()

    private val _banners = MutableStateFlow<List<BannerModel>>(emptyList())
    val banners = _banners.asStateFlow()

    private val _categories = MutableStateFlow<List<DataItem>>(emptyList())
    val categories = _categories.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val toolsData = async { getTools() }
            val bannersData = async { getBanners() }
            val categoriesData = async { getDataItem() }

            _tools.value = toolsData.await()
            _banners.value = bannersData.await()
            _categories.value = categoriesData.await()
        }
    }

    /*FAKE DATA FROM REMOTE*/
    private suspend fun getTools(): List<ToolModel> {
        return listOf(
            ToolModel("AI Enhance", 1, ToolStatus.HOT),
            ToolModel("AI Beauty", 1, ToolStatus.NONE),
            ToolModel("AI Expand", 1, ToolStatus.NONE),
            ToolModel("Fitting", 1, ToolStatus.NONE),
            ToolModel("AI Enhance", 1, ToolStatus.SOON),
            ToolModel("AI Hair", 1, ToolStatus.NONE)
        )
    }

    private suspend fun getBanners() : List<BannerModel>{
        return listOf(
            BannerModel("a", R.drawable.img_home_banner_1),
            BannerModel("a", R.drawable.img_home_banner_2),
            BannerModel("a", R.drawable.img_home_banner_3)
        )
    }

    private suspend fun getDataItem() : List<DataItem>{
        return listOf(
            DataItem(
                title = "Clothing",
                categories = listOf(
                    CategoryModel("", "Bana"),
                    CategoryModel("", "Aline"),
                    CategoryModel("", "Match"),
                    CategoryModel("", "Oh No"),
                    CategoryModel("", "Oh No")
                )
            ),
            DataItem(
                title = "Shoes",
                categories = listOf(
                    CategoryModel("", "Bana"),
                    CategoryModel("", "Aline"),
                    CategoryModel("", "Match"),
                    CategoryModel("", "Oh No"),
                    CategoryModel("", "Oh No")
                )
            ),
            DataItem(
                title = "Beauty",
                categories = listOf(
                    CategoryModel("", "Bana"),
                    CategoryModel("", "Aline"),
                    CategoryModel("", "Match"),
                    CategoryModel("", "Oh No"),
                    CategoryModel("", "Oh No")
                )
            ),
            DataItem(
                title = "Ablaa",
                categories = listOf(
                    CategoryModel("", "Bana"),
                    CategoryModel("", "Aline"),
                    CategoryModel("", "Match"),
                    CategoryModel("", "Oh No"),
                    CategoryModel("", "Oh No")
                )
            ),
            DataItem(
                title = "AI Beauty",
                categories = listOf(
                    CategoryModel("", "Bana"),
                    CategoryModel("", "Aline"),
                    CategoryModel("", "Match"),
                    CategoryModel("", "Oh No"),
                    CategoryModel("", "Oh No")
                )
            )
        )
    }

}

